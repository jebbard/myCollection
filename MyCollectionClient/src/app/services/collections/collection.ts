import {CollectionStatistics} from './collection-statistics';

export class Collection {
  id: number;
  name: string;
  localRootPath: string;
  thumbnailLink: string;
  pictureLink: string;
  statistics: CollectionStatistics;
}
