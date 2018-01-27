import {Component, OnInit, Input} from '@angular/core';
import {CollectionView} from '../collection-view/collection-view';
import {CollectionViewMode} from '../collection-view/collection-view-mode';

@Component({
  selector: 'app-collection-details',
  templateUrl: './collection-details.component.html',
  styleUrls: ['./collection-details.component.css']
})
export class CollectionDetailsComponent implements OnInit {

  @Input() collectionView: CollectionView;

  constructor() {
  }

  ngOnInit() {
  }

  synchCollection(): void {
    // Todo
  }

  switchToEditMode(): void {
    this.collectionView.mode = CollectionViewMode.EDIT;
  }

  saveChangedCollection(): void {
    // Todo
    this.collectionView.mode = CollectionViewMode.VIEW;
  }

}
