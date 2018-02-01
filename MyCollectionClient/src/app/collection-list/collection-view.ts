import {Collection} from '../services/collections/collection';
import {CollectionViewMode} from './collection-view-mode';

/*
  Represents view state and view data of a
  collection view.
 */
export class CollectionView {
  public collection: Collection;

  public constructor(private originalCollection: Collection, public mode: CollectionViewMode) {
    this.createClonedCollection();
  }

  createClonedCollection(): void {
    this.collection = Object.assign({}, this.originalCollection);
  }

  edit(): void {
    this.createClonedCollection();
    this.mode = CollectionViewMode.EDIT;
  }

  save(): void {
    this.originalCollection = this.collection;
    this.mode = CollectionViewMode.VIEW;
  }

  discard(): void {
    this.collection = this.originalCollection;
    this.mode = CollectionViewMode.VIEW;
  }

  open(): void {
    this.mode = CollectionViewMode.VIEW;
  }

  close(): void {
    this.mode = CollectionViewMode.CLOSED;
  }

  collectionChanged(col: Collection) {
    this.originalCollection = col;
    this.createClonedCollection();
  }

  delete(): void {
    this.mode = CollectionViewMode.IN_DELETE;
  }
}
