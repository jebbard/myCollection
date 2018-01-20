import { Component, OnInit } from '@angular/core';
import { Collection } from '../services/collections/collection';
import {CollectionService} from '../services/collections/collection.service';

@Component({
  selector: 'app-collection-list',
  templateUrl: './collection-list.component.html',
  styleUrls: ['./collection-list.component.css']
})
export class CollectionListComponent implements OnInit {

  collections: Collection[];

  constructor(private collectionService: CollectionService) { }

  ngOnInit() {
    this.getCollections();
  }

  getCollections(): void {
    this.collectionService.getCollections().subscribe(collections => this.collections = collections);
  }

  delete(collection: Collection): void {
    this.collections = this.collections.filter(c => c !== collection);
    this.collectionService.deleteCollection(collection).subscribe();
  }
}
