import {CollectionItemType} from './collection-item-type';

export class CollectionItem {
  id: number;
  name: string;
  parentFolder: string;
  type: CollectionItemType;
}
