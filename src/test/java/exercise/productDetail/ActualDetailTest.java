package exercise.productDetail;

import exercise.typeAndRate.ProductType;
import junit.framework.TestCase;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ActualDetailTest extends TestCase {

    private ActualDetail actualDetail;
    private ShelfDetail shelfDetail;

    @Before
    public void setUp() {
        shelfDetail = new ShelfDetail(12.49, ProductType.IMPORTED_TAXABLE);
        actualDetail = new ActualDetail(ProductType.IMPORTED_TAXABLE, shelfDetail);
    }

    public void testGetPrice() throws Exception {
        assertThat(actualDetail.getTaxRate(), is(0.125));
    }

    public void testGetTaxRate() throws Exception {

    }

    public void testGetTax() throws Exception {

    }

    public void testGetCost() throws Exception {

    }
}