import { Component, OnInit } from '@angular/core';
import { Collection } from '../services/collections/collection'
import { COLLECTIONS } from './mock-collections'

@Component({
  selector: 'app-collection-list',
  templateUrl: './collection-list.component.html',
  styleUrls: ['./collection-list.component.css']
})
export class CollectionListComponent implements OnInit {

  collections = COLLECTIONS;

  constructor() { }

  ngOnInit() {
  }

}
