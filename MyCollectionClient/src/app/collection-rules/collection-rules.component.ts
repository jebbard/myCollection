import { Component, OnInit, Input } from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';

@Component({
  selector: 'app-collection-rules',
  templateUrl: './collection-rules.component.html',
  styleUrls: ['./collection-rules.component.css']
})
export class CollectionRulesComponent implements OnInit {

  @Input() collectionView: CollectionView;

  constructor() { }

  ngOnInit() {
  }

}
