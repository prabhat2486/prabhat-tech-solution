package com.prabhattechtest.springboot.bto;

import com.prabhattechtest.springboot.model.Client;
import com.prabhattechtest.springboot.model.DailySummary;
import com.prabhattechtest.springboot.model.Product;
import com.prabhattechtest.springboot.model.Transaction;
import com.prabhattechtest.springboot.readers.ClientReader;
import com.prabhattechtest.springboot.readers.ProductReader;
import com.prabhattechtest.springboot.readers.TransactionReader;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class TransactionProcessor {

    private final String INPUT_FILE_PATH = "input.txt";
    private final String OUTPUT_FILE_PATH = "Output.csv";

    /*
    Processes input file and writes daily summary in Output.csv
    returns Transaction array which is used by DailySummary controller to return JSON response.
     */
    public ArrayList<DailySummary> getDailySummary() throws IOException, URISyntaxException {

        HashMap<Client, HashMap<Product, Transaction>> summary = new HashMap<>();
        Stream<String> stream = Files.lines(Paths.get(this.getClass().getClassLoader().getResource(INPUT_FILE_PATH).toURI()));
        stream.forEach((l) -> {
            StringBuilder line = new StringBuilder(l);
            Client client = ClientReader.getClient(line);
            Product product = ProductReader.getProduct(line);
            Transaction transaction = TransactionReader.getTransaction(line);
            addTransactionToSummary(summary, client, product, transaction);
        });
        return prepareDailySummary(summary);
    }

    /*
    Add Daily Transaction Summary to Map.
     */
    private void addTransactionToSummary(HashMap<Client, HashMap<Product, Transaction>> summary, Client client, Product product, Transaction transaction){
        if(summary.containsKey(client)){
            HashMap<Product, Transaction> p = summary.get(client);
            if(p.containsKey(product)){
                Transaction t = p.get(product);
                t.setNetTransactionAmount(t.getNetTransactionAmount() + transaction.getNetTransactionAmount());
            }else {
                p.put(product, transaction);
            }
        }else {
            HashMap<Product, Transaction> productSummary = new HashMap<>();
            productSummary.put(product, transaction);
            summary.put(client, productSummary);
        }
    }


    /*
    Writes Output.csv based on Summary Map processed after reading input file.
     */
    private ArrayList<DailySummary> prepareDailySummary(HashMap<Client, HashMap<Product, Transaction>> summary) throws IOException {

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH)));
        out.println("Client_Information,Product_Information,Total_Transaction_Amount");
        ArrayList<DailySummary> dailySummary = new ArrayList<>();
        summary.forEach((c,product_map) ->{
            product_map.forEach((p, t) -> {
                DailySummary d = new DailySummary(c.toString(), p.toString(), t.toString());
                out.println(d);
                dailySummary.add(d);
            });
        });
        out.close();
        return dailySummary;
    }
}
