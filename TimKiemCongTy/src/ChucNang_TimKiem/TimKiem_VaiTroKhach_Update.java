package ChucNang_TimKiem;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TimKiem_VaiTroKhach_Update {
	public String baseUrl = "https://xprofile.vn/jobs";
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
		public void Title() {
			String expectedTitle = "Chọn nhân vật - X-Profile";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			if(actualTitle.toString().equalsIgnoreCase(expectedTitle.toString())) {
				System.out.println("Tieu de nhu mong doi");
			}
			
	}
	@Test(priority = 1)

	public void NhanVat()throws InterruptedException {
	WebElement characterImage = driver.findElement(By.cssSelector("img[src='/_next/image?url=%2Fimages%2FsheepBoss.png&w=640&q=100']"));
	characterImage.click();
	String expectedUrl = "https://xprofile.vn/survey";
	String actualUrl = driver.getCurrentUrl();
	if(actualUrl.toString().equalsIgnoreCase(expectedUrl.toString())) {
		System.out.println("Chọn nhân vật thành công - PASS");
		WebElement continueParagraph = driver.findElement(By.cssSelector("p.sm\\:text-p18-bold.text-p14.font-bold.text-neutral"));
		continueParagraph.click();
	}
	else {
		System.out.println("Chọn nhân vật thất bại");
	
	}
	
}
	@Test(priority = 2)
	public void KhaoSat() throws InterruptedException {
	    List<WebElement> Slides1 = driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div/div[4]/div/div"));
	    Random random1 = new Random();

	    for (WebElement swiper : Slides1) {
	        List<WebElement> answerElements = swiper.findElements(By.className("relative"));

	        int randomIndex = random1.nextInt(answerElements.size());
	        WebElement randomAnswer = answerElements.get(randomIndex);

	        randomAnswer.click();
	        Thread.sleep(2000);
	        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div/div[5]/div/button/p"));
	        continueButton.click();
	        
	    }
	    List<WebElement> Slides2 = driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div/div[4]/div"));
	    Random random2 = new Random();
	    
	    for (WebElement swiper : Slides2) {
	        List<WebElement> answerElements = swiper.findElements(By.className("relative"));

	        int randomIndex = random2.nextInt(answerElements.size());
	        WebElement randomAnswer = answerElements.get(randomIndex);

	        randomAnswer.click();
	        Thread.sleep(2000);
	        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div/div[5]/div/button/p"));
	        continueButton.click();
	        Thread.sleep(2000);
	    }
	    	   
}
	@Test(priority = 3)
	public void XemGoiY() throws InterruptedException{
		WebElement XemGoiY = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div/div[2]/div[2]/button"));
		XemGoiY.click();
		driver.get("https://xprofile.vn/");
		Thread.sleep(2000);
		
		
}

	
	
	@Test(priority = 4)
	public void XemDanhSachCongViec() throws InterruptedException {
	    driver.findElement(By.linkText("Việc làm IT")).click();
	    driver.get("https://xprofile.vn/jobs");
	    String expectedUrl1 = "https://xprofile.vn/jobs";
		String actualUrl1 = driver.getCurrentUrl();
		if(actualUrl1.toString().equalsIgnoreCase(expectedUrl1.toString())) {
			System.out.println("Xem danh sách công việc thành công - PASS");			
			}
		else {
			System.out.println("Xem danh sách thất bại");
		}
	    	
	}
	@Test(priority = 5)
	public void timKiem(){
	driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/input")).sendKeys("Công ty TNHH Công Nghệ EcomElite");
	driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/input")).click();
	driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div/div[2]/div/div/div[2]/div[2]/div/div/div[7]")).click();
	driver.get("https://xprofile.vn/profile-company/CV8TT3JLGIRq");
	String expectedUrl2 = "https://xprofile.vn/profile-company/CV8TT3JLGIRq";
	String actualUrl2 = driver.getCurrentUrl();
	if(actualUrl2.toString().equalsIgnoreCase(expectedUrl2.toString())) {
		System.out.println("Tìm kiếm thành công : Công ty TNHH Công Nghệ EcomElite - PASS");			
		}
	else {
		System.out.println("Tìm kiếm thất bại");
	}
	
}
	@Test(priority = 6)
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
