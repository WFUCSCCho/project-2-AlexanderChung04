# Project 2 @ CSC 201 Fall 2025: AVL Tree

## Pledged Work Policy

This is a ___Pledged Work___ assignment.  This means that the work you submit for grading ___must___ be your work product.  
You may not submit the work of others outside of your team, or the modification of work of others outside of your team.
You are encouraged to talk with each other about general problems.  For example, you may talk to someone about "What does it mean when the compiler says there is a semicolon missing on line 20", or "I can not get my assignment template to download from GitHub, what did you do?".  However, you may not engage in "Could you send me a copy of your work so I can see how to get started?".  You may get full and detailed assistance from me, the Teaching Assistant (TA), and the TAs in the Computer Science Center.  If you have any question about the appropriateness of assistance, do not hesitate to consult with me.

Use of ChatGPT or similar resources are encouraged but they must be documented in this README.md. That includes 1) the exact prompt used, 2) the screenshots of the outputs, and 3) your personal assessment on how useful it was. Even erroneous or unuseful results must be documented.

If I believe you have violated our ___Pledge Work___ agreement, I will pursue this matter through the college Honor Council.

## Overview

An AVL Tree is a type of self-balancing Binary Search Tree (BST) that ensures that the tree is approximately balanced. An AVL Tree remains balanced as elements are inserted or deleted. During class, we discussed the general algorithms for a BST and an AVL tree.  In particular, we emphasized how a regular BST structure can become basically a linked list if its balance is not maintained, resulting in a O(N) running time instead of the O(log N) we expect from a properly balanced BST.

In this project, you will:
1. Implement a generic BST with an iterator interface. (You developed this in Project 1, which you can use as is or update.)
2. Implement a generic AVL Tree with an iterator interface.
3. Insert sorted and randomized datasets into BST and AVL Trees.
4. Time the insertion and search operations for BST and AVL Trees.
5. Graph and analyze the insertion and search operation timings.

## Invocation and I/O Files:

The name of the program is `Proj2` ( provided with a `main` method in`Proj2.java` ). 

You are encouraged to run and debug code in __IntelliJ IDEA__. Also, the program can be invoked from the command-line as:

```shell
java Proj2 {dataset-file} {number of lines}
```

## 1. **Generic BST with Iterator Interface**

You already created Node and BST classes with a Comparable Interface for Project 1. If your implementation is perfect, you can simply copy over your files and continue to the next section. However, you can make whatever modifications that you deem necessary to complete this project.

## 2. **Generic AVL Tree Interface**

I have enclosed three starter codes:
1. `AvlTree.java`
2. `TestAvl.java`
3. `Proj2.java`

The `AvlTree.java` file contains an overall structure of that AVL Tree class, and you are expected to complete the code where it is indicated (Search for `// FINISH ME`). The `TestAvl.java` file must not be modified, and it will be used for testing your AVL Tree class. It does not check for every error, but I hope that it will be helpful for you. The `Proj2.java` file contains a starter code for you to implement the main driver of the program.

## 3. **Sorted and Randomized Datasets for BST and AVL Trees**

You already created a well-written class to store the records from a dataset for Project 1. If your dataset and implementation is perfect, you can simply copy over your files. However, you can make whatever modifications that you deem necessary to complete this project, and you can also choose a completely different dataset. The source of the dataset and modifications made to it must be documented inside the class.

I have enclosed `Proj2.java` that takes in two command line arguments: 1) the filename if your dataset, and 2) the number of lines of your dataset to read. 

You will read your dataset and store the data in an ArrayList. To sort and randomize your ArrayList, you will use the `Collections.sort()` and `Collections.shuffle()` commands.

You will then insert each element if your sorted and randomized ArrayLists into BST and AVL Trees. In total, there will be four trees.

You will then use your original ArrayList to search for each element in your BST and AVL Trees. In total, you will be searching four times.

## 4. **Time the Insertion and Search operations for BST and AVL Trees**

For each of the insertion and search operations, you will use `System.nanoTime()` to calculate the time it takes to run the insertion and search operations for the sorted and randomized BST and AVL Trees. Your program will print out the number of lines and the times to insert and search for BST and AVL Trees to the screen in a human-readable format (i.e., nice to look at) and also separtely to a file named `output.txt` in CSV format. Each time the program runs, it will append the timing results to `output.txt`.

## 5. Graph and analyze the insertion and search operation for BST and AVL Trees**

Run your program several times for different number of lines of your dataset, N, by choosing different values of the second command line argument. After several runs, your `output.txt` file will be filled with timing data.

Using your favorite graphing software (e.g., MS Excel or Google Sheets), plot the running time (in seconds) and rate (in seconds per node) vs. N for each case, comparing the BST and AVL Trees (i.e., two lines per graph). Take a screenshot of your graph and put them here by modifying this file, committing, and pushing it to this repository.

Dataset from kaggle, Delete top 10 since it is different years, deleted last two empty lines of dataset, changed the three ramens with no rating to a 0 rating, deleted “,” from ramen variety

AI Documentation: 

I began to implement private AvlNode remove, but got stuck so I asked DeepSeek. I gave it a prompt with my half finished code. It was quite useful here for creating and helping me understand the code I was missing. 

<img width="832" height="528" alt="prompt 1" src="https://github.com/user-attachments/assets/070c81a8-2052-438c-a5d8-a084fb71f88a" />
<img width="651" height="687" alt="answer 1" src="https://github.com/user-attachments/assets/6cbad7a9-d8f8-4972-9169-77470fd3062e" />

It used a ? at the end which I didn’t understand so I asked it to explain. Also useful here and provided me with an alternate version that was easier to understand.

<img width="615" height="622" alt="1 add" src="https://github.com/user-attachments/assets/6d29bdfc-2bb0-4d85-8607-e12e1024f3f5" />

I wanted a good idea for how to structure the contains code, so I asked “can you provide me with a general outline for the contains method of an AVL tree in Java.” Was somewhat helpful along with a google search

<img width="507" height="622" alt="contains" src="https://github.com/user-attachments/assets/05df780c-3838-4be5-89fe-8387e14964cb" />

I was a little confused on if the BST vs AVL graphs were supposed to use data from the sorted or randomized trees so I pasted the instructions into the prompt, and asked “just to clarify are the graphs supposed to be for the sorted or randomized trees?” The explanation was quite useful here, helping me understand the outputs and graphs.

<img width="500" height="756" alt="222poo" src="https://github.com/user-attachments/assets/805e6868-143d-4abd-b590-83d87a440365" />

I got a little confused on how System.nanoTime works so I used the prompt, “how is system.nanotime used in java, and how might it be used with the instructions I sent you?” Wasn’t exactly what I was looking for so I googled to see what it actually returns.

<img width="505" height="782" alt="nano" src="https://github.com/user-attachments/assets/79277efc-eb86-4bf1-8ed1-5f94f8ededa6" />


BST vs. AVL Tree running time (insertion):

<img width="752" height="467" alt="g1" src="https://github.com/user-attachments/assets/722c9ed7-8358-4286-b89a-34dcf13b7d06" />


BST vs. AVL Tree running time (search):

<img width="615" height="382" alt="g2" src="https://github.com/user-attachments/assets/de32521c-0a64-4236-9404-5fb7034a1ffa" />


BST vs. AVL Tree running rate (insertion):

<img width="597" height="370" alt="g3" src="https://github.com/user-attachments/assets/6b2b9edf-556c-4a1d-8f1d-e538b8c2853f" />


BST vs. AVL Tree running rate (search):

<img width="603" height="366" alt="g4" src="https://github.com/user-attachments/assets/1b7ef65b-0a89-4014-b064-e8c4c03627d3" />



## Submission:

Your project will be developed and graded via GitHub. Your final "push" is your final submission, and it must occur before it is due. On Canvas, enter the url to your Github repository. Your project will not be graded without it.

## Recommendations:

I ___strongly suggest___ that you carefully think through your strategy before just jumping into the code.  Once that is working, start adding in new features individually.  A good place to start is building your class.

*In order to get full points of Commenting and Code Style, you need to add comments to every methods and head comments for each file (providing file description, author, date, and acknowledgement).

```
/∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: filename.java
∗ @description: This program implements . . .
∗ @author: Your Name
∗ @date: October 21, 2025
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗/
```
