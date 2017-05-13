import { KotbootPage } from './app.po';

describe('kotboot App', () => {
  let page: KotbootPage;

  beforeEach(() => {
    page = new KotbootPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
