package com.bitbox.selectionproces;

import com.bitbox.selectionproces.model.Item;
import com.bitbox.selectionproces.model.PriceReduction;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PriceReductionDateTest {
    PriceReduction priceReduction;
    PriceReduction priceReduction2;
    PriceReduction priceReduction3;
    PriceReduction priceReduction4;
    Item item;

    @Before
    public void init() throws ParseException {
        item=new Item();
        item.setId(1L);
        item.setState(true);
        item.setCreationDate(new Date());
        item.setCode_id(2L);
        item.setDescription("jaja");
        priceReduction=new PriceReduction(2L,  55L,
                new SimpleDateFormat("dd/MM/yyyy").parse("2002/10/19 10:23:54"),
                new SimpleDateFormat("dd/MM/yyyy").parse("2003/10/19 10:23:54"));
        priceReduction2=new PriceReduction(1L,  55L,
                new SimpleDateFormat("dd/MM/yyyy").parse("2004/10/19 10:23:54"),
                new SimpleDateFormat("dd/MM/yyyy").parse("2006/10/19 10:23:54"));
        priceReduction3=new PriceReduction(3L, 55L,
                new SimpleDateFormat("dd/MM/yyyy").parse("2009/10/19 10:23:54"),
                new SimpleDateFormat("dd/MM/yyyy").parse("2014/10/19 10:23:54"));
        priceReduction4=new PriceReduction(4L,  55L,
                new SimpleDateFormat("dd/MM/yyyy").parse("2004/10/19 10:23:54"),
                new SimpleDateFormat("dd/MM/yyyy").parse("2005/10/19 10:23:54"));
    }
    @Test
    public void TestAddDate(){
        item.addPriceReduction(priceReduction2);
        assertEquals(1,item.getPriceReductionList().size());
        item.addPriceReduction(priceReduction3);
        assertEquals(2,item.getPriceReductionList().size());
        item.addPriceReduction(priceReduction4);
        assertEquals(2,item.getPriceReductionList().size());
        item.addPriceReduction(priceReduction);
        assertEquals(3,item.getPriceReductionList().size());
    }
}
