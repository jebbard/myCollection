import {Collection} from '../services/collections/collection';
import {CollectionViewMode} from './collection-view-mode';

/*
  Represents view state and view data of a
  collection view.
 */
export class CollectionView {
  public collection: Collection;

  public constructor(private originalCollection: Collection, public mode: CollectionViewMode) {
    this.collection = originalCollection;
  }
}
