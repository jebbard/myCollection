import { Component, OnInit, Input } from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';
import {CollectionViewMode} from '../collection-list/collection-view-mode';

@Component({
  selector: 'app-collection-toolbar',
  templateUrl: './collection-toolbar.component.html',
  styleUrls: ['./collection-toolbar.component.css']
})
export class CollectionToolbarComponent implements OnInit {

  @Input() collectionView: CollectionView;
  @Input() isFormValid: boolean;

  constructor() { }

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

  createNewCollection(): void {
    // Todo
    this.collectionView.mode = CollectionViewMode.VIEW;
  }

  closeCollection(): void {
    this.collectionView.mode = CollectionViewMode.CLOSED;
  }

  discardChangedOrNewCollection(): void {
    this.collectionView.mode = CollectionViewMode.VIEW;
    this.collectionView.discardChanges();
  }
}
