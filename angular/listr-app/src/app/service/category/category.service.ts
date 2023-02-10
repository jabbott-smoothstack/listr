import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Category } from 'src/app/interfaces/CategoryInterface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private CATEGORY_SERVICE_URI: string;

  constructor(private http: HttpClient) { 
    this.CATEGORY_SERVICE_URI = environment.CATEGORY_SERVICE_URI;
  }

  public createCategory(id: Number, newCategoryName: String) : Observable<Category> {
    return this.http.post<Category>(this.CATEGORY_SERVICE_URI, {listId: id, categoryName: newCategoryName});
  }

  public getCategoriesByListId(id: Number): Observable<Category[]> {
    return this.http.get<Category[]>(this.CATEGORY_SERVICE_URI + id);
  }

  public editCategory(id: Number, categoryName: String): Observable<Category> {
    return this.http.put<Category>(this.CATEGORY_SERVICE_URI, {categoryId: id, newCategoryName: categoryName});
  }

  public deleteCategory(id: Number): Observable<Category> {
    return this.http.delete<Category>(this.CATEGORY_SERVICE_URI + id);
  }
}
