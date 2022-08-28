package org.example;

import org.example.enity.Block;

public class BlockChainTest {
    public static void main(String[] args) {
        // 第一个区块
        Block firstBlock = new Block("我是第一个区块","0");
        firstBlock.mineBlock(5);// 挖矿难度5
        System.out.println("第一区块hash：" + firstBlock.hash);

        // 第二个区块
        Block twoBlock = new Block("我是第二个区块",firstBlock.hash);
        twoBlock.mineBlock(6);// 挖矿难度5
        System.out.println("第二区块hash：" + twoBlock.hash);

        // 第三个区块
        Block threeBlock = new Block("我是第三个区块", twoBlock.hash);
        threeBlock.mineBlock(7);// 挖矿难度5
        System.out.println("第三区块hash：" + threeBlock.hash);
    }
}
