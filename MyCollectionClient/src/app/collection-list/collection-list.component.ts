import {Component, OnInit} from '@angular/core';
import {CollectionService} from '../services/collections/collection.service';
import {CollectionViewMode} from '../collection-view/collection-view-mode';
import {CollectionView} from '../collection-view/collection-view';

@Component({
  selector: 'app-collection-list',
  templateUrl: './collection-list.component.html',
  styleUrls: ['./collection-list.component.css']
})
export class CollectionListComponent implements OnInit {

  collectionViews: CollectionView[];

  selectedView: CollectionView;

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
        this.selectedView = this.collectionViews[0];
      }
    });
  }

  notifyDeletedCollection(deletedView: CollectionView): void {
    this.collectionViews = this.collectionViews.filter(c => c !== deletedView);
  }

  notifyAddedCollection(addedView: CollectionView): void {
    this.collectionViews.unshift(addedView);
  }

  notifyToggledCollection(toggledView: CollectionView): void {
    if (this.selectedView) {
      if (this.selectedView !== toggledView) {
        this.selectedView.mode = CollectionViewMode.CLOSED;
        toggledView.mode = CollectionViewMode.VIEW;
      } else {
        if (toggledView.mode === CollectionViewMode.VIEW) {
          toggledView.mode = CollectionViewMode.CLOSED;
        } else {
          toggledView.mode = CollectionViewMode.VIEW;
        }
      }

      this.selectedView = toggledView;
    }
  }

  newCollection(): void {
    // var newCollection = new Collection();
    // newCollection.name = "<New collection>";
    // this.collections.unshift(newCollection);
    // this.openedCollection = newCollection;
  }
}
