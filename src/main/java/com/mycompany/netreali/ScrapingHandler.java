/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

/**
 *
 * @author oshrat
 */
public class ScrapingHandler {
    private final YNETScraper ynetScraper;
    private final MaarivScraper maarivScraper;
    private final HaaretzScraper haaretzScraper;
    
    public ScrapingHandler() {
        ynetScraper = new YNETScraper();
        maarivScraper = new MaarivScraper();
        haaretzScraper = new HaaretzScraper();
    }                
    
    public void scrapeAndSave(int searchTaskId) {
        ynetScraper.scrapeAndSave(searchTaskId);
        maarivScraper.scrapeAndSave(searchTaskId);
        haaretzScraper.scrapeAndSave(searchTaskId);
    }
}
