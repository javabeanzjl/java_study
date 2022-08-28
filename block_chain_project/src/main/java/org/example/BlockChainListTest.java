package org.example;

import org.example.enity.Block;
import org.example.util.JsonUtil;

import java.util.ArrayList;

public class BlockChainListTest {
    
    // 用于存储所有的区块信息
    public static ArrayList<Block> blockChain = new ArrayList<>();
    
    // 挖矿难度，计算前几位数是合法的
    public static int difficulty = 5;

    public static void main(String[] args) {
        blockChain.add(new Block("我是第一个区块" , "0"));
        blockChain.get(0).mineBlock(difficulty);
        
        blockChain.add(new Block("我是第二个区块" , blockChain.get(blockChain.size() - 1).hash));
        blockChain.get(blockChain.size() - 1).mineBlock(difficulty);
        
        blockChain.add(new Block("我是第三个区块" , blockChain.get(blockChain.size() - 1).hash));
        blockChain.get(blockChain.size() - 1).mineBlock(difficulty);

        // System.out.println("区块链是否合法：" + isChainVaild());
        // System.out.println(JsonUtil.toJson(blockChain));
        
        // 尝试修改第一个区块，看看是否还合法
        blockChain.set(0,new Block("第一个区块", "1"));
        System.out.println("区块链是否合法：" + isChainVaild());
        System.out.println(JsonUtil.toJson(blockChain));
    }
    public static Boolean isChainVaild() {
        
        Block cuurentBlock;
        Block previousBlock;
        boolean flag = true;
        
        String hashTarget = new String(new char[difficulty]).replace('\0','0');
        
        // 循环遍历列表验证hash
        for (int i = 1; i < blockChain.size(); i++) {
            cuurentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);
            
            // 比较注册的hash和计算的hash
            if (!cuurentBlock.hash.equals(cuurentBlock.calculateHash())) {
                System.out.println("当前hash不相等");
                flag = false;
            }
            // 比较当前的前一个hash与注册的前一个hash
            if (!previousBlock.hash.equals(cuurentBlock.previousHash)) {
                System.out.println("前一个hash不相等");
                flag = false;
            }
            // 检测该区块是不是已经被计算出来了
            if (!cuurentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("该区块还没有被开采，也就是你这个区块他是不合法的");
                flag=false;
            }
        }
        return flag;
    }
}
