/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.iva.clientranking;

public class SampleExecutor {

    public static String[] sampleFiles =
            new String[]{"files/test1/c1.csv", "files/test1/a1.csv", "files/test1/s1.csv", "files/test1/p1.csv"};

    public static void main(String[] args) {
        ClientRankingApplication.main(sampleFiles);
    }

}
