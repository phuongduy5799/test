package ChucNang_TimKiem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TimKiem_VaiTroNguoiDung_Update {
	public String baseUrl = "https://xprofile.vn/sign-in";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;
	
	@BeforeTest
		public void setUp()throws InterruptedException {
			System.out.println("CHAY TRINH DUYET CHROME");
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver();
			driver.get(baseUrl);
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	
	@Test(priority = 0)
    public void loginTest() throws InterruptedException{
        // Nhập tên người dùng
        driver.findElement(By.id("email")).sendKeys("bdua5375@gmail.com");
        // Nhập mật khẩu
        driver.findElement(By.id("password")).sendKeys("Autotest2024@");
        
        // Nhấp vào nút Đăng nhập
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div/div[1]/div[1]/form/div[4]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Việc làm IT")).click();
	    driver.get("https://xprofile.vn/jobs");
        String expectedUrl = "https://xprofile.vn/jobs";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
   		System.out.println("Đăng nhập thành công -PASS");
       	}
       	else {
   		System.out.println("Đăng nhập thất bại");
    	
       	}
     }
	@Test(priority = 1)
	public void TimKiem_TheoTen()throws InterruptedException{
		// Tìm kiếm với từ khóa Market
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/input")).sendKeys("market");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/input")).clear();
		Thread.sleep(2000);
		// Tìm kiếm với thông tin đầy đủ
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/input")).sendKeys("Mindful Living Institute");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div")).click();
		driver.get("https://xprofile.vn/profile-company/mli");
		String expectedUrl2 = "https://xprofile.vn/profile-company/mli";
		String actualUrl2 = driver.getCurrentUrl();
		if(actualUrl2.toString().equalsIgnoreCase(expectedUrl2.toString())) {
			System.out.println("Tìm kiếm thành công : Mindful Living Institute - PASS");			
			}
		else {
			System.out.println("Tìm kiếm thất bại");
		}
		
		
	}
	@Test(priority = 2)
	public void TimKiem_TheoDiaDiem()throws InterruptedException{
			driver.findElement(By.linkText("Việc làm IT")).click();
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div/div[2]/p")).click();
			driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[2]/div/button/p")).click();
			Thread.sleep(2000);	        
	        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[1]/p/span"));
	        if (errorMessage.isDisplayed() && errorMessage.getText().equals("công ty ở Hà Nội")) {
	        	System.out.println("Tìm kiếm thành công theo địa điểm công ty - PASS");
	        } else {
	        	System.out.println("Thông báo: Tìm kiếm sai thông tin - Lỗi chức năng - False");
	        }
	        System.out.println("Xem thông tin mô tả địa chỉ có đúng địa điểm tìm kiếm hay không");
	        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[2]/div/div/div[1]/div")).click();
	        Thread.sleep(2000);
	        WebElement DiaDiem = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[4]/div[1]/div/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]"));
	        String DiaDiemCongTy = DiaDiem.getText();

	        String DiaDiemTimKiem = "Hà Nội";

	        if (DiaDiemCongTy.contains(DiaDiemTimKiem)) {
	            System.out.println("Thông tin địa điểm tìm kiếm đúng - Fass");
	        } else {
	            System.out.println("Thông báo: Lỗi chức năng tìm kiếm theo địa điểm - False");
	        }
		}

	@AfterClass
	    public void tearDown() {
	        driver.close();
	    }
}
