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

  saveChanges(changedCollection: Collection): void {
    this.originalCollection = changedCollection;
    this.createClonedCollection();
    this.originalCollection = this.collection;
    this.mode = CollectionViewMode.VIEW;
  }

  edit(): void {
    this.createClonedCollection();
    this.mode = CollectionViewMode.EDIT;
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

  delete(): void {
    this.mode = CollectionViewMode.IN_DELETE;
  }

  isInCreation(): boolean {
    return this.mode === CollectionViewMode.NEW || this.mode === CollectionViewMode.IN_CREATE;
  }

  isInUpdate(): boolean {
    return this.mode === CollectionViewMode.EDIT || this.mode === CollectionViewMode.IN_UPDATE;
  }

  isOpened(): boolean {
    return this.mode === CollectionViewMode.VIEW || this.isInUpdate();
  }

  isChangeInProgress(): boolean {
    return this.mode === CollectionViewMode.IN_UPDATE || this.mode === CollectionViewMode.IN_CREATE || this.mode === CollectionViewMode.IN_DELETE;
  }
}
