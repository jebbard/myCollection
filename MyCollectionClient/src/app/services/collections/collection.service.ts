import {Injectable} from '@angular/core';
import {MessageService} from '../messages/message.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {catchError, tap} from 'rxjs/operators';
import {Collection} from './collection';
import {of} from 'rxjs/observable/of';
import {CollectionItem} from './collection-item';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CollectionService {

  constructor(private http: HttpClient, private messageService: MessageService) { }

  private collectionsUrl = 'api/collections';  // URL to web api
  private foldersUrlPart = 'folders';
  private itemsUrlPart = 'items';

  getCollections(): Observable<Collection[]> {
    return this.http.get<Collection[]>(this.collectionsUrl)
      .pipe(
        tap(collections => this.log(`fetched collections`)),
        catchError(this.handleError('getCollections', [])));
  }

  updateCollection (collection: Collection): Observable<any> {
    return this.http.put(this.collectionsUrl, collection, httpOptions).pipe(
      tap(_ => this.log(`updated collection id=${collection.id}`)),
      catchError(this.handleError<any>('updateCollection'))
    );
  }

  addCollection (collection: Collection): Observable<Collection> {
    return this.http.post<Collection>(this.collectionsUrl, collection, httpOptions).pipe(
      tap((theCollection: Collection) => this.log(`added collection w/ id=${theCollection.id}`)),
      catchError(this.handleError<Collection>('addCollection'))
    );
  }

  deleteCollection (collection: Collection | number): Observable<Collection> {
    const id = typeof collection === 'number' ? collection : collection.id;
    const url = `${this.collectionsUrl}/${id}`;

    return this.http.delete<Collection>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted collection id=${id}`)),
      catchError(this.handleError<Collection>('deleteCollection'))
    );
  }

  getCollectionItemsInFolder(collection: Collection, parent: CollectionItem): Observable<CollectionItem[]> {
    const url = `${this.collectionsUrl}/${collection.id}/${this.foldersUrlPart}/${parent.id}/${this.itemsUrlPart}`;

    return this.http.get<CollectionItem[]>(url)
      .pipe(
        tap(collectionItems => this.log(`fetched collection items`)),
        catchError(this.handleError('getCollections', [])));
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add('CollectionService: ' + message);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
