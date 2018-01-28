import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Collection} from './collections/collection';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const collections = [
      {
        id: 1,
        name: 'Rock',
        localRootPath: 'E:\\Musik\\Rock\\',
        statisticsSummary: '10 albums, 203 songs',
        thumbnailLink: 'a',
        pictureLink: ''
      },
      {
        id: 2,
        name: 'Electronic',
        localRootPath: 'E:\\Musik\\Electronic\\',
        statisticsSummary: '20 labels, 300 releases, 3045 songs',
        thumbnailLink: 'b',
        pictureLink: ''
      },
      {
        id: 3,
        name: 'Andere',
        localRootPath: 'E:\\Musik\\Andere\\',
        statisticsSummary: '111 songs, 1000 folders',
        thumbnailLink: 'c',
        pictureLink: ''
      }
    ];
    return {collections};
  }
}
