import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/UserInterface';
import { List } from 'src/app/interfaces/ListInterface';
import { CategoryService } from 'src/app/service/category/category.service';
import { ItemService } from 'src/app/service/item/item.service';
import { ListService } from 'src/app/service/list/list.service';
import { UserService } from 'src/app/service/user/user.service';
import { Category } from 'src/app/interfaces/CategoryInterface';
import { Item } from 'src/app/interfaces/ItemInterface';
import { CategoriesWithItems } from 'src/app/interfaces/CategoriesWithItems';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})

export class MainComponent implements OnInit {

  private userInfo: User;
  private lists: List[];
  private categories: Category[];
  private categoriesWithItems: CategoriesWithItems[];
  private selectedListId: Number;
  private selectedCategoryId: Number;
  private selectedItemId: Number;
  private newListName: String;
  private newCategoryName: String;
  private newItemName: String;

  constructor(private userService: UserService, private listService: ListService, private categoryService: CategoryService, private itemSerivce: ItemService) { 
    
  }

  ngOnInit() {
    this.userService.getSignedInUser().then((userResponse) => {
      this.userInfo = userResponse;
      console.log(this.userInfo);
      this.getListsByUserId();
    });
    
  }

  public getListsByUserId() {
    if(this.userInfo.userId !== undefined) {
      return this.listService.getListsByUserId(this.userInfo.userId).subscribe({
        next: (lists: List[]) => {
          this.lists = lists;
        },
        error: (err: Error) => {
          console.log(err);
        }
      });
    }
    
  }

  public getCategoriesByListId() {
    if(this.selectedListId !== undefined) {
      this.categories = [];
      this.categoryService.getCategoriesByListId(this.selectedListId).subscribe({
        next: (categories: Category[]) => {
          this.categories = categories;
          console.log(this.categories);
          this.getItemsByCategoryId();
        },
        error: (err: Error) => {
          console.log(err);
        }
      });
    }
  }

  public getItemsByCategoryId() {
    this.categoriesWithItems = [];
    this.categories.forEach(category => {
      this.itemSerivce.getItemsByCategoryId(category.categoryId).subscribe({
        next: (retrievedItems: Item[]) => {
          this.categoriesWithItems.push({
            categoryId: category.categoryId,
            categoryName: category.categoryName,
            categoryListId: category.categoryListId,
            items: retrievedItems
          });
        },
        error: (err: Error) => {
          console.log(err);
        },
        complete: () => {
          console.log(this.categoriesWithItems);
        }
      })
    });
  }

  public createList() {
    this.listService.createList(this.userInfo.userId, this.newListName).subscribe({
      next: (newList: List) => {
        console.log(newList);
        this.getListsByUserId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  public createCategory() {
    this.categoryService.createCategory(this.selectedListId, this.newCategoryName).subscribe({
      next: (newCategory: Category) => {
        console.log(newCategory);
        this.getCategoriesByListId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  public createItem() {
    this.itemSerivce.createItem(this.selectedCategoryId, this.newItemName).subscribe({
      next: (item: Item) => {
        console.log(item);
        this.getItemsByCategoryId()
      }
    })
  }

  public editList() {
    this.listService.editList(this.selectedListId, this.newListName).subscribe({
      next: (list: List) => {
        console.log(list);
        this.getListsByUserId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  public editCategory() {
    this.categoryService.editCategory(this.selectedCategoryId, this.newCategoryName).subscribe({
      next: (category: Category) => {
        console.log(category);
        this.getCategoriesByListId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  public editItem() {
    this.itemSerivce.editItem(this.selectedItemId, this.newItemName).subscribe({
      next: (item: Item) => {
        console.log(item);
        this.getItemsByCategoryId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  public deleteList() {
    this.listService.deleteList(this.selectedListId).subscribe({
      next: (list: List) => {
        console.log(list);
        this.getListsByUserId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    })
  }

  public deleteCategory() {
    this.categoryService.deleteCategory(this.selectedCategoryId).subscribe({
      next: (category: Category) => {
        console.log(category);
        this.getCategoriesByListId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  public deleteItem(itemId: Number) {
    this.itemSerivce.deleteItem(itemId).subscribe({
      next: (item: Item) => {
        console.log(item);
        this.getItemsByCategoryId();
      },
      error: (err: Error) => {
        console.log(err);
      }
    });
  }

  public setSelectedListId(id: Number) {
    this.selectedListId = id;
    this.getCategoriesByListId();
  }

  public setSelectedListIdWithoutCategories(id: Number) {
    this.selectedListId = id;
  }

  public setSelectedCategoryId(id: Number) {
    this.selectedCategoryId = id;
  }

  public setSelectedItemId(id: Number) {
    this.selectedItemId = id;
  }
}
