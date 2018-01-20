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
        thumbnailLink: '',
        pictureLink: ''
      },
      {
        id: 2,
        name: 'Electronic',
        localRootPath: 'E:\\Musik\\Electronic\\',
        statisticsSummary: '20 labels, 300 releases, 3045 songs',
        thumbnailLink: '',
        pictureLink: ''
      },
      {id: 3, name: 'Andere', localRootPath: 'E:\\Musik\\Andere\\', statisticsSummary: '111 songs', thumbnailLink: '', pictureLink: ''}
    ];
    return {collections};
  }
}
