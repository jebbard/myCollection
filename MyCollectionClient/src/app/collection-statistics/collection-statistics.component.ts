import { Component, OnInit, Input } from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';

@Component({
  selector: 'app-collection-statistics',
  templateUrl: './collection-statistics.component.html',
  styleUrls: ['./collection-statistics.component.css']
})
export class CollectionStatisticsComponent implements OnInit {

  @Input() collectionView: CollectionView;

  constructor() { }

  ngOnInit() {
  }

}
