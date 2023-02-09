import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { List } from 'src/app/interfaces/ListInterface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  private LIST_SERVICE_URI: string;
  constructor(private http: HttpClient) { 
    this.LIST_SERVICE_URI = environment.LIST_SERVICE_URI;
  }

  public getListsByUserId(id: Number) : Observable<List[]> {
    return this.http.get<List[]>(this.LIST_SERVICE_URI + 'all/' + id);
  }

  public createList(listUserId: Number, newListName: String) : Observable<List> {
    return this.http.post<List>(this.LIST_SERVICE_URI, {userId: listUserId, listName: newListName});
  }

  public editList(id: Number, listName: String) : Observable<List> {
    return this.http.put<List>(this.LIST_SERVICE_URI, {listId: id, newListName: listName});
  }

  public deleteList(id: Number) : Observable<List> {
    return this.http.delete<List>(this.LIST_SERVICE_URI + id);
  }

}
