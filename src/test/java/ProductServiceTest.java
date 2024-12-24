import com.practice.ecommorce.Model.Product;
import com.practice.ecommorce.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductService productService; // Mocking ProductService

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test
    }

    @Test
    public void getProductById() {
        long productId = 1;

        // Create a mock product to return
        Product mockProduct = new Product();
        mockProduct.setId(productId);
        mockProduct.setTitle("Test Product"); // Set other properties as needed

        // Define the behavior of the mocked service
        when(productService.getProductById(productId)).thenReturn(mockProduct);

        // Call the method and assert
        Product result = productService.getProductById(productId);
        assertEquals(1, result.getId());
    }

    
}
