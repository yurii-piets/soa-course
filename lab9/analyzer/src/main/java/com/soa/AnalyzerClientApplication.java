package com.soa;

import com.soa.ws.Analyzer;
import com.soa.ws.AnalyzerImplService;

public class AnalyzerClientApplication {

    public static void main(String[] args) {
        AnalyzerImplService analyzerImplService = new AnalyzerImplService();
        Analyzer analyzer = analyzerImplService.getAnalyzerImplPort();
        System.out.println(analyzer.analyze("Aaa   1234"));
    }
}
