import { Component, OnInit, Input } from '@angular/core';
import { Collection } from '../services/collections/collection';

@Component({
  selector: 'app-collection-details',
  templateUrl: './collection-details.component.html',
  styleUrls: ['./collection-details.component.css']
})
export class CollectionDetailsComponent implements OnInit {

  @Input() collection: Collection;
  @Input() openedCollection: Collection;

  constructor() { }

  ngOnInit() {
  }

}
