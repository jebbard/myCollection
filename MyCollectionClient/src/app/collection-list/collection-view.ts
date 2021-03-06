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

  updateCollection(changedCollection: Collection): void {
    this.originalCollection = changedCollection;
    this.createClonedCollection();
    this.originalCollection = this.collection;
  }

  saveChanges(changedCollection: Collection): void {
    this.updateCollection(changedCollection);
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

  isInSynchronization(): boolean {
    return this.mode === CollectionViewMode.IN_SYNCHRONIZATION;
  }

  isInDeletion(): boolean {
    return this.mode === CollectionViewMode.IN_DELETE;
  }

  isViewed(): boolean {
    return this.mode === CollectionViewMode.VIEW;
  }

  isOpened(): boolean {
    return this.isViewed() || this.isInUpdate() || this.isInSynchronization();
  }

  isChangeInProgress(): boolean {
    return this.mode === CollectionViewMode.IN_UPDATE || this.mode === CollectionViewMode.IN_CREATE || this.mode === CollectionViewMode.IN_DELETE;
  }
}
