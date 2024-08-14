package com.sourav.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MatrixMultiplicationMain {
    private static final int MATRIX_SIZE = 3;
    private static final int THREAD_COUNT = MATRIX_SIZE; // Number of threads equals number of rows

    public static void main(String[] args) {


        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrixB = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Result matrix
        int[][] result = new int[MATRIX_SIZE][MATRIX_SIZE];

        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
            // This task runs when all threads reach the barrier
            System.out.println("All threads reached the barrier. Multiplication completed.");
            printMatrix(result);
        });

        // Create and start threads for matrix multiplication
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new Multiplication(matrixA, matrixB, result, i, barrier));
            thread.start();
        }
    }

    static class Multiplication implements Runnable {

        private final int[][] matrixA;
        private final int[][] matrixB;
        private final int[][] result;
        private final int row;
        private final CyclicBarrier barrier;

        public Multiplication(int[][] matrixA, int[][] matrixB, int[][] result, int row, CyclicBarrier barrier) {
            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.result = result;
            this.row = row;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            // Perform multiplication for the assigned row
            for (int j = 0; j < MATRIX_SIZE; j++) {
                for (int k = 0; k < MATRIX_SIZE; k++) {
                    result[row][j] += matrixA[row][k] * matrixB[k][j];
                }
            }

            System.out.println("Thread " + Thread.currentThread().getName() + " completed row " + row);

            try {
                // Wait at the barrier for other threads
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println("Error :{} " + e.getMessage());
            }
        }
    }

    // Method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

