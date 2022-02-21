package org.larkinfo.desktop.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class info {
    public String charaterName;
	public String basic, battle, engrave, tendency, cardTxt;
	public String itemLevel, battleLevel, expeditionLevel;
    
    public void setName(String name)
	{
		charaterName = name;
	}

    public String getData() throws Exception{
		
		String URL = "https://lostark.game.onstove.com/Profile/Character/" + charaterName;
		Document doc = Jsoup.connect(URL).get();
		Elements itemL = doc.select("div.level-info2__expedition").select("span");
		Elements battleL = doc.select("div.level-info__item").select("span");
		Elements expeditionL = doc.select("div.level-info__expedition").select("span");
		Elements baiscAbility = doc.select("div.profile-ability-basic").select("span");
		Elements battleAblity = doc.select("div.profile-ability-battle").select("span");
		Elements engraveAblity = doc.select("div.profile-ability-engrave").select("span");
		Elements tendencyAblity = doc.select("div.profile-ability-tendency.chart-states-wrap.states_box");
		Elements cardText = doc.select("div.profile-card__text");
		
		System.out.println(tendencyAblity);
		itemLevel = itemL.text();
		battleLevel = battleL.text();
		expeditionLevel = expeditionL.text();
		basic = baiscAbility.text();
		battle = battleAblity.text();
		engrave = engraveAblity.text();
		tendency = tendencyAblity.text();
		cardTxt = cardText.text();

        System.out.println(URL);
        return itemLevel;

	}
}
