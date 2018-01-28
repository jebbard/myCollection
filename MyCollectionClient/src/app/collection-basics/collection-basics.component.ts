import {Component, OnInit, Input, ElementRef, ViewChild, AfterViewInit} from '@angular/core';
import {CollectionView} from '../collection-list/collection-view';

@Component({
  selector: 'app-collection-basics',
  templateUrl: './collection-basics.component.html',
  styleUrls: ['./collection-basics.component.css']
})
export class CollectionBasicsComponent implements OnInit, AfterViewInit {

  @Input() collectionView: CollectionView;
  @ViewChild('input1') inputEl: ElementRef;

  constructor() {
  }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.inputEl.nativeElement.focus();
  }

  selectFolder(file): void {
    alert("HALLO");
    this.collectionView.collection.localRootPath = file;
  }

}
