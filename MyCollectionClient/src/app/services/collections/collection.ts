import {CollectionStatistics} from './collection-statistics';

export class Collection {
  id: number;
  name: string;
  localRootPath: string;
  pictureType: string;
  statistics: CollectionStatistics;
}
