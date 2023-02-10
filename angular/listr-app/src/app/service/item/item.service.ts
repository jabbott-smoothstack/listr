import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from 'src/app/interfaces/ItemInterface';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private ITEM_SERVICE_URI: string;

  constructor(private http: HttpClient) {
    this.ITEM_SERVICE_URI = environment.ITEM_SERVICE_URI;
  }

  public getItemsByCategoryId(id: Number) : Observable<Item[]> {
    return this.http.get<Item[]>(this.ITEM_SERVICE_URI + id);
  }

  public createItem(categoryId: Number, itemName: String): Observable<Item> {
    return this.http.post<Item>(this.ITEM_SERVICE_URI, {itemCategoryId: categoryId, newItemName: itemName});
  }

  public editItem(id: Number, itemName: String): Observable<Item> {
    return this.http.put<Item>(this.ITEM_SERVICE_URI, {itemId: id, newItemName: itemName});
  }

  public deleteItem(id: Number): Observable<Item> {
    return this.http.delete<Item>(this.ITEM_SERVICE_URI + id);
  }
}
