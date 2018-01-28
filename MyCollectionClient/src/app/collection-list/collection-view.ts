import {Collection} from '../services/collections/collection';
import {CollectionViewMode} from './collection-view-mode';

/*
  Represents view state and view data of a
  collection view.
 */
export class CollectionView {
  public collection: Collection;

  public constructor(private originalCollection: Collection, public mode: CollectionViewMode) {
    // Clone the original collection to a copied collection
    this.collection = new Collection();
    this.collection.name = originalCollection.name;
    this.collection.thumbnailLink = originalCollection.thumbnailLink;
    this.collection.localRootPath = originalCollection.localRootPath;
    this.collection.id = originalCollection.id;
    this.collection.pictureLink = originalCollection.pictureLink;
    this.collection.statisticsSummary = originalCollection.statisticsSummary;
  }

  discardChanges(): void {
    this.collection = this.originalCollection;
  }
}
