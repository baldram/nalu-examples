/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.content.search;

import com.github.mvp4g.nalu.client.ui.AbstractComponentController;
import com.github.mvp4g.nalu.client.ui.annotation.Controller;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.Selectors;

@Controller(route = "/search/:searchName/:searchCity", selector = Selectors.CONTENT, component = SearchComponent.class, componentInterface = ISearchComponent.class)
public class SearchController
  extends AbstractComponentController<NaluSimpleApplicationContext, ISearchComponent>
implements ISearchComponent.Controller{

  public SearchController() {
  }

  @Override
  public void start() {
    this.eventBus.fireEvent(new StatusChangeEvent("Please enter data!"));
  }

  @Override
  public void doClickSearchButton(String searchName,
                                  String searchCity) {
    // fuer NavigatiponPresenter speichern ...
    this.context.setSearchCity(searchCity);
    this.context.setSearchName(searchName);
    this.router.route("/list",
                      searchName,
                      searchCity);
  }

  public void setSearchName(String searchName) {
    if ("undefined".equals(searchName) &&
        searchName.trim()
                  .length() > 0) {
      this.component.setSearchName(searchName);
    }
  }

  public void setSearchCity(String searchCity) {
    if ("undefined".equals(searchCity) &&
        searchCity.trim()
                  .length() > 0) {
      this.component.setSearchCity(searchCity);
    }
  }
}
