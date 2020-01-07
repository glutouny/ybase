package com.yl.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/31  23:20
 */
public class TestGenerateCsvFile {


    public final static List<String> pluList = new ArrayList<String>(){
        {
//            2000123511085-----41365350007000
//            2000123511290-----41365350008000
//            2000123511306-----41365309007000
            add("2000123511085");
            add("2000123511290");
            add("2000123511306");
        }
    };

    /**
     * CSV文件生成方法
     * @param head 文件头
     * @param dataList 数据列表
     * @param outPutPath 文件输出路径
     * @param filename 文件名
     * @return
     */
    public static File createCSVFile(List<Object> head, List<List<Object>> dataList, String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "UTF-8"), 1024);
            // 写入文件头部
//            writeRow(head, csvWtriter);

            // 写入文件内容
            for (List<Object> row : dataList) {
                writeRow(row, csvWtriter);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     * 写一行数据方法
     * @param row
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
        // 写入文件头部
        int count  = 0;
        for (Object data : row) {
            StringBuffer sb = new StringBuffer();
            sb.append(data);
            count ++;
            if (count != row.size()) {
                sb.append(",");
            }
            String rowStr = sb.toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }

    public static List<List<Object>> createOrderInsertData(String status,long number) {
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object>  data = null;
        int a = 1000000;
        for (int i = 0;i < number; i++) {
            data = new ArrayList<>();
            //564928292860509397   0-
            //564938292860509397   1-错误转换
            //564948292860509397   1-退款单错误转换
            //564958292860509397   1-plu错误转换
            String ecsOrderId = "564950509377"+(a+i);
            String ecsEntryNo = "564951509377"+(a+i);
//            String status = "paid";
            data.add(ecsOrderId);
            data.add(ecsEntryNo);
            data.add(status);
            datalist.add(data);
        }
        return datalist;
    }

    public static List<List<Object>> createOrderInsertData_2(String status,long number) {
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object>  data = null;
        int a = 1000000;
        for (int i = 100000;i < number; i++) {
            data = new ArrayList<>();
            //564928292860509397
            String ecsOrderId = "564950509377"+(a+i);
            String ecsEntryNo_1 = "564951509377"+(a+i);
            String ecsEntryNo_2 = "564952509377"+(a+i);
//            String status = "paid";
            data.add(ecsOrderId);
            data.add(ecsEntryNo_1);
            data.add(ecsEntryNo_2);
            data.add(status);
            datalist.add(data);
        }
        return datalist;
    }

    public static List<List<Object>> createRefundOrderInsertData() {
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object>  data = null;
        int a = 1000000;
        int b = 100000;
        for (int i = 150000;i < 200000; i++) {
            data = new ArrayList<>();
            //34045062110509793     -0
            //34046062110509793     -1 错误转换
            String return_order_id = "340465092793"+(b+i);
            //564928292860509397
            String ecsOrderId = "564950509377"+(a+i);
            String ecsEntryNo = "564951509377"+(a+i);

            data.add(return_order_id);
            data.add(ecsOrderId);
            data.add(ecsEntryNo);
            datalist.add(data);
        }
        return datalist;
    }

    public static List<List<Object>> createPluInsertData(String status,long number) {
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object>  data = null;
        int a = 1000000;
        for (int i = 0;i < number; i++) {
            data = new ArrayList<>();
            //564928292860509397
            //564958292860509397  -plu错误数据转换
            String msgId = "654950999377"+(a+i);
            String ecsOrderId = "564950509377"+(a+i);
            String ecsEntryNo = "564951509377"+(a+i);
            data.add(msgId);
            data.add(status);
            data.add(ecsOrderId);
            data.add(ecsEntryNo);
            data.add(pluList.get(i % 3));
            datalist.add(data);
        }
        return datalist;
    }


    public static List<List<Object>> createPluInsertData_2(String status) {
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object>  data = null;
        int a = 1000000;
        for (int i = 0;i < 50000; i++) {
            data = new ArrayList<>();
            //564928292860509397
            String ecsEntryNo = "564951509377"+(a+i);
            data.add(status);
            data.add(ecsEntryNo);
            data.add(pluList.get(i % 3));
            datalist.add(data);
        }
        return datalist;
    }




    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        List<Object> exportData = new ArrayList<Object>();
        List<List<Object>> datalist = null;
        String fileName;
        //订单数据-paid
//        datalist = createOrderInsertData("paid",100000);
//        fileName = "order";
//
//        datalist = createOrderInsertData("PACKAGED",100000);
//        fileName = "order_packaged";

//        datalist = createOrderInsertData("success",50000);
//        fileName = "order_success";
//        -订单错误数据-56493
//        datalist = createOrderInsertData("paid",70000);
//        fileName = "refundorder_error";

        //退款单错误转换对应订单数据--56494
//        datalist = createOrderInsertData("paid",70000);
//        fileName = "order_refundOrder_error";
        //plu错误转换对应订单数据--56495
//        datalist = createOrderInsertData("paid",70000);
//        fileName = "order_plu_error";

        //订单数据多行
//          datalist = createOrderInsertData_2("paid",150000);
//          fileName = "multiOrder";
//          datalist = createOrderInsertData_2("PACKAGED",200000);
//          fileName = "multiOrder_packaged";
//          datalist = createOrderInsertData_2("success",150000);
//          fileName = "multiOrder_success";



        //退款单数据
//        datalist = createRefundOrderInsertData();
//        fileName = "refundOrder";
//        error
//        datalist = createRefundOrderInsertData();
//        fileName = "refundOrder_error";


        //退款单数据
//        String fulfillStatus = "PICKED";
////        String fulfillStatus = "SHIPPING";
//        datalist = createPluInsertData(fulfillStatus,200000);
//        fileName = "pluFulfill_"+fulfillStatus;

        String fulfillStatus = "ENTER_WAREHOUSE_SUCCESS";
                datalist = createPluInsertData_2(fulfillStatus);
        fileName = "pluFulfill_"+fulfillStatus;

//          错误数据 7w
//          String fulfillStatus = "PICKED";
//          datalist = createPluInsertData(fulfillStatus,70000);
//          fileName = "pluFulfill_error"+fulfillStatus;

        String path = "d:/";

        File file = createCSVFile(exportData, datalist, path, fileName);
        String fileName2 = file.getName();
        System.out.println("文件名称：" + fileName2);
    }

}
