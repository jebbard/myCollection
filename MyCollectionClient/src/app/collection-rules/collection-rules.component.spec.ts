import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectionRulesComponent } from './collection-rules.component';

describe('CollectionRulesComponent', () => {
  let component: CollectionRulesComponent;
  let fixture: ComponentFixture<CollectionRulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CollectionRulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollectionRulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
