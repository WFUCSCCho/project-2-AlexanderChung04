import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;

public class Proj2 {
    public static void main(String[] args) throws IOException {
        // Use command line arguments to specify the input file
        if (args.length != 2) {
            System.err.println("Usage: java TestAvl <input file> <number of lines>");
            System.exit(1);
        }

        String inputFileName = args[0];
        int numLines = Integer.parseInt(args[1]);

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

	// FINISH ME

        ArrayList<Ramen> list = new ArrayList<>();
        int count = 0;
        while(inputFileNameScanner.hasNextLine() && count < numLines){
            String ln = inputFileNameScanner.nextLine().trim();
            if(!ln.isEmpty()){
                String[] data = ln.split(",");

                        int reviewNum = Integer.parseInt(data[0].trim());
                        String brand = data[1].trim();
                        String variety = data[2].trim();
                        String style = data[3].trim();
                        String country = data[4].trim();
                        double stars = Double.parseDouble(data[5].trim());

                        Ramen newRamen = new Ramen(reviewNum, brand,variety, style,country, stars);
                        list.add(newRamen);
                        count++;
                    }
            }
        inputFileNameScanner.close();
        inputFileNameStream.close();

        ArrayList<Ramen> sorted = new ArrayList<>(list);
        ArrayList<Ramen> random = new ArrayList<>(list);
        Collections.sort(sorted);
        Collections.shuffle(random);

        BST<Ramen> sortedBST = new BST<>();
        BST<Ramen> randomBST = new BST<>();
        AVLTree<Ramen> sortedAVL = new AVLTree<>();
        AVLTree<Ramen> randomAVL = new AVLTree<>();

        long sBSTimeInsert = System.nanoTime();
        for(Ramen ramen : sorted){
            sortedBST.insertVal(ramen);
        }
        sBSTimeInsert = System.nanoTime() - sBSTimeInsert;

        long rBSTimeInsert = System.nanoTime();
        for(Ramen ramen : random){
            randomBST.insertVal(ramen);
        }
        rBSTimeInsert = System.nanoTime() - rBSTimeInsert;

        long sBSTimeSearch = System.nanoTime();
        for(Ramen ramen : sorted){
            sortedBST.searchVal(ramen);
        }
        sBSTimeSearch = System.nanoTime() - sBSTimeSearch;

        long rBSTimeSearch = System.nanoTime();
        for(Ramen ramen : random){
            randomBST.searchVal(ramen);
        }
        rBSTimeSearch = System.nanoTime() - rBSTimeSearch;

        long sAVLTimeInsert = System.nanoTime();
        for(Ramen ramen : sorted){
            sortedAVL.insert(ramen);
        }
        sAVLTimeInsert = System.nanoTime() - sAVLTimeInsert;

        long rAVLTimeInsert = System.nanoTime();
        for(Ramen ramen : random){
            randomAVL.insert(ramen);
        }
        rAVLTimeInsert = System.nanoTime() - rAVLTimeInsert;

        long sAVLTimeSearch = System.nanoTime();
        for(Ramen ramen : sorted){
            sortedAVL.contains(ramen);
        }
        sAVLTimeSearch = System.nanoTime() - sAVLTimeSearch;

        long rAVLTimeSearch = System.nanoTime();
        for(Ramen ramen : random){
            randomAVL.contains(ramen);
        }
        rAVLTimeSearch = System.nanoTime() - rAVLTimeSearch;

        System.out.println("Number of lines read: " + numLines);
        System.out.println("Insertion times for BST and AVL");
        System.out.println("BST sorted insertion time: " + sBSTimeInsert);
        System.out.println("AVL sorted insertion time: " + sAVLTimeInsert);
        System.out.println("BST randomized insertion time: " + rBSTimeInsert);
        System.out.println("AVL randomized insertion time: " + rAVLTimeInsert);
        System.out.println("Search times for BST and AVL");
        System.out.println("BST sorted search time: " + sBSTimeSearch);
        System.out.println("AVL sorted search time: " + sAVLTimeSearch);
        System.out.println("BST randomized search time: " + rBSTimeSearch);
        System.out.println("AVL randomized search time: " + rAVLTimeSearch);

        try(PrintWriter fileWriter = new PrintWriter(new FileOutputStream("output.txt",true))){
            fileWriter.println(numLines + ", " + sBSTimeInsert + ", " + sAVLTimeInsert + ", " + rBSTimeInsert + ", " + rAVLTimeInsert + ", " + sBSTimeSearch + ", " + sAVLTimeSearch + ", " + rBSTimeSearch + ", " + rAVLTimeSearch);

        } catch (IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
        }




    }
}
