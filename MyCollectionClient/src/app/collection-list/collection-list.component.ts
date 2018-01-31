import {Component, OnInit} from '@angular/core';
import {CollectionService} from '../services/collections/collection.service';
import {CollectionViewMode} from './collection-view-mode';
import {CollectionView} from './collection-view';
import {Collection} from '../services/collections/collection';

@Component({
  selector: 'app-collection-list',
  templateUrl: './collection-list.component.html',
  styleUrls: ['./collection-list.component.css']
})
export class CollectionListComponent implements OnInit {

  newCollectionView: CollectionView;

  collectionViews: CollectionView[];

  openedCollectionView: CollectionView;

  constructor(private collectionService: CollectionService) {
  }

  ngOnInit() {
    this.getCollections();
  }

  getCollections(): void {
    this.collectionViews = [];
    this.collectionService.getCollections().subscribe(collections => {
      for (let i = 0; i < collections.length; i++) {
        const collectionView = new CollectionView(collections[i], CollectionViewMode.CLOSED);

        this.collectionViews.push(collectionView);
      }

      if (collections.length > 0) {
        this.openedCollectionView = this.collectionViews[0];
      }
    });
  }

  notifyDeletedCollection(deletedView: CollectionView): void {
    this.collectionViews = this.collectionViews.filter(c => c !== deletedView);
  }

  notifyAddedCollection(addedView: CollectionView): void {
    this.collectionViews.unshift(addedView);
    this.openedCollectionView.close();
    this.openedCollectionView = addedView;
  }

  notifyToggledCollection(toggledView: CollectionView): void {
    if (this.openedCollectionView) {
      if (this.openedCollectionView.mode === CollectionViewMode.EDIT) {
        if (confirm('This will discard any changes. Continue?')) {
          this.openedCollectionView.discard();
        }
      }

      if (this.openedCollectionView !== toggledView) {
        this.openedCollectionView.mode = CollectionViewMode.CLOSED;
        toggledView.mode = CollectionViewMode.VIEW;
      } else {
        if (toggledView.mode === CollectionViewMode.VIEW) {
          toggledView.mode = CollectionViewMode.CLOSED;
        } else {
          toggledView.mode = CollectionViewMode.VIEW;
        }
      }

      this.openedCollectionView = toggledView;
    }
  }

  newCollection(): void {
    this.newCollectionView = new CollectionView(new Collection(), CollectionViewMode.NEW);
  }
}
