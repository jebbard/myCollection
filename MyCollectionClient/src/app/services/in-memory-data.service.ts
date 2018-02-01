import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Collection} from './collections/collection';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const collections = [
      {
        id: 1,
        name: 'Rock',
        localRootPath: 'E:\\Musik\\Rock\\',
        statistics: {
          statisticsSummary: '10 albums, 203 songs',
          numberOfFiles: 1234,
          numberOfFolders: 200,
          totalSizeInBytes: 281818,
        },
        thumbnailLink: 'a',
        pictureLink: ''
      },
      {
        id: 2,
        name: 'Electronic',
        localRootPath: 'E:\\Musik\\Electronic\\',
        statistics: {
          statisticsSummary: '20 labels, 300 releases, 3045 songs',
          numberOfFiles: 12342,
          numberOfFolders: 2300,
          totalSizeInBytes: 51818,
        },
        thumbnailLink: 'b',
        pictureLink: ''
      },
      {
        id: 3,
        name: 'Andere',
        localRootPath: 'E:\\Musik\\Andere\\',
        statistics: {
          statisticsSummary: '111 songs, 1000 folders',
          numberOfFiles: 34,
          numberOfFolders: 10,
          totalSizeInBytes: 8909,
        },
        thumbnailLink: 'c',
        pictureLink: ''
      }
    ];
    return {collections};
  }
}
