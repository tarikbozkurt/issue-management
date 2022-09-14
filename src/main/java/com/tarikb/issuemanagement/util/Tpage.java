package com.tarikb.issuemanagement.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class Tpage<T> {

    //Frontend için Veritabanından çekilecek verilerin düzenlenmesi
    //serverside pagination kayıtlar gözükecek

    //number : kaçıncı sayfa gözüküyor (1.sayfa,2.sayfa.. gibi)
    private int number;
    //front end in kayıtları kaçarlı gösteriyor.. size kısmı
    private int size;
    // herhangi bir colonda sıralama yapacak
    private Sort sort;
    //toplamda kaç sayfa oluştu (10 arlı gösterimde 100 veri 10 sayfa )
    private int totalPages;
    //toplam kayıt sayısı
    private Long totalElements;
    //döneceği datayı gösterecek
    private List<T> content;

    public void setStat(Page page, List<T> list){
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;



    }


}
