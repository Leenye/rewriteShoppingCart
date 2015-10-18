package exercise.productDetail;

import exercise.typeAndRate.ProductType;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShelfDetailTest extends TestCase {

    private ShelfDetail shelfDetailForDomesticExempt;
    private ShelfDetail shelfDetailForImportedTaxable;

    @Before
    public void setUp() {
        shelfDetailForDomesticExempt = new ShelfDetail(12.49, ProductType.DOMESTIC_EXEMPT);
        shelfDetailForImportedTaxable = new ShelfDetail(12.49, ProductType.IMPORTED_TAXABLE);
    }

    @Test
    public void testGetPrice() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getPrice(), is(12.49));
        assertThat(shelfDetailForImportedTaxable.getPrice(), is(12.49));
    }

    @Test
    public void testGetTaxRate() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getTaxRate(), is(0.00));
        assertThat(shelfDetailForImportedTaxable.getTaxRate(), is(0.150));
    }

    @Test
    public void testGetTax() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getTax(), is(0.00));
        assertThat(shelfDetailForImportedTaxable.getTax(), is(1.90));
    }

    @Test
    public void testGetCost() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getCost(), is(12.49));
        assertThat(shelfDetailForImportedTaxable.getCost(), is(14.39));
    }
}