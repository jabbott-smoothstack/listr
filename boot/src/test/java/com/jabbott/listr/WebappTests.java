package com.jabbott.listr;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebappTests {
	
	private WebDriver driver;
  
  @BeforeClass
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
	  
	  driver = new ChromeDriver();
	  
  }
  
  @Test(priority = 1)
  public void signupUser() {
	  driver.get("http://localhost:8080/signup");
	  driver.findElement(By.id("firstName")).sendKeys("John");
	  driver.findElement(By.id("email")).sendKeys("test");
	  driver.findElement(By.id("password")).sendKeys("test");
	  driver.findElement(By.id("signupButton")).click();
	  
	  if(driver.findElement(By.id("signup-success-message")).isDisplayed()) {
		  return;
	  }
  }
  
  @Test(priority = 2)
  public void userLogin() throws InterruptedException {
	  driver.get("http://localhost:8080/");
	  driver.findElement(By.id("email")).sendKeys("test");
	  driver.findElement(By.id("password")).sendKeys("test");
	  driver.findElement(By.id("signinButton")).click();
	  synchronized (driver) {
		  driver.wait(1000);
		  Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/listspage");
	  }
	  
  }
  
  @Test(priority = 3)
  public void createList() throws InterruptedException {
	  driver.findElement(By.id("createList")).click();
	  driver.findElement(By.id("listnameInput")).sendKeys("Test List");
	  driver.findElement(By.id("createListModalButton")).click();
	  
	  synchronized (driver) { 
		  driver.wait(1000);
		  driver.findElement(By.className("list-item")).click();
		  
		  Assert.assertEquals(driver.findElement(By.className("list-item")).isDisplayed(), true);
		  
	  }
	  
  }
  
  @Test(priority = 4)
  public void createCategory() throws InterruptedException {
	  driver.findElement(By.id("createCategory")).click();
	  driver.findElement(By.id("categoryInput")).sendKeys("Test Category");
	  driver.findElement(By.id("createCategoryModalButton")).click();
	  synchronized (driver) {
		  driver.wait(1000);
		  List<WebElement> categoryItems = driver.findElements(By.className("category-card"));
		  
		  Assert.assertEquals(categoryItems.size() > 0, true);
		  
	  }
	  
  }
  
  @Test(priority = 5)
  public void createItem() throws InterruptedException {	  
	  synchronized(driver) {
		  driver.wait(1000);
		  driver.findElement(By.id("addItemButton")).click();
		  driver.findElement(By.id("newItemInput")).sendKeys("Test Item");
		  driver.findElement(By.id("addItemModalButton")).click();
		  driver.wait(500);
		  List<WebElement> listItems = driver.findElements(By.className("item"));
		  
		  Assert.assertEquals(listItems.size() > 0, true);
		  
	  }
  }
  
  @Test(priority = 6)
  public void editList() throws InterruptedException {
	  synchronized(driver) {
		  driver.wait(500);
		  driver.findElement(By.id("editListButton")).click();
		  driver.findElement(By.id("editListInput")).clear();
		  driver.findElement(By.id("editListInput")).sendKeys("Test List Edited");
		  driver.findElement(By.id("editListModalButton")).click();
		  driver.get("http://localhost:8080/listspage");
		  driver.wait(500);
		  WebElement listElement = driver.findElement(By.className("listName"));
		  
		  Assert.assertEquals(listElement.getText(), "Test List Edited");
		  
	  }
  }
  
  @Test(priority = 7)
  public void editCategory() throws InterruptedException {
	  synchronized(driver) {
		  driver.wait(500);
		  driver.findElement(By.id("editCategoryButton")).click();
		  driver.findElement(By.id("editCategoryInput")).clear();
		  driver.findElement(By.id("editCategoryInput")).sendKeys("Test Category Edited");
		  driver.findElement(By.id("updateCategoryModalButton")).click();
		  driver.get("http://localhost:8080/listspage");
		  driver.wait(500);
		  WebElement categoryElement = driver.findElement(By.id("Test Category Edited"));
		  
		  Assert.assertEquals(categoryElement.getText(), "Test Category Edited");
		  
	  }
  }
  
  
  @Test(priority = 8)
  public void editItem() throws InterruptedException {
	  synchronized (driver) {
		  driver.findElement(By.id("Test Category Edited")).click();
		  driver.wait(500);
		  driver.findElement(By.id("editItemButton")).click();
		  driver.findElement(By.id("editItemInput")).clear();
		  driver.findElement(By.id("editItemInput")).sendKeys("Test Item Edited");
		  driver.findElement(By.id("editItemModalButton")).click();
		  driver.get("http://localhost:8080/listspage");
		  driver.wait(500);
		  driver.findElement(By.id("Test Category Edited")).click();
		  driver.wait(500);
		  WebElement itemElement = driver.findElement(By.className("itemName"));
		  
		  Assert.assertEquals(itemElement.getText(), "Test Item Edited");
		  
	  }
  }
  
  @Test(priority = 9)
  public void deleteItem() throws InterruptedException {
	  synchronized(driver) {
		  driver.findElement(By.id("deleteItemButton")).click();
		  driver.wait(500);
		  driver.findElement(By.id("Test Category Edited")).click();
		  driver.wait(500);
		  List<WebElement> listItems = driver.findElements(By.className("item"));
		  
		  Assert.assertEquals(listItems.size(), 0);
		  
	  }
  }
  
  @Test(priority = 10)
  public void deleteCategory() throws InterruptedException {
	  synchronized(driver) {
		  driver.findElement(By.id("deleteCategoryButton")).click();
		  driver.findElement(By.id("deleteCategoryModalButton")).click();
		  driver.wait(500);
		  driver.get("http://localhost:8080/listspage");
		  driver.wait(500);
		  
		  
		  Assert.expectThrows(NoSuchElementException.class, () -> {
			  WebElement categoryItem = driver.findElement(By.id("Test Category Edited"));
		  });
		  
	  }
  }
  
  @Test(priority = 11)
  public void deleteList() throws InterruptedException {
	  synchronized(driver) {
		  driver.findElement(By.id("deleteListButton")).click();
		  driver.findElement(By.id("removeListModalButton")).click();
		  driver.wait(500);
		  driver.get("http://localhost:8080/listspage");
		  driver.wait(500);
		  
		  Assert.expectThrows(NoSuchElementException.class, () -> {
			  WebElement listItem = driver.findElement(By.className("list-item"));
		  });
		  
	  }
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
}
