package action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 17/6/19.
 */
public class KeywordAction extends BaseAction {
    /* @inParam

     */
    private String input;//用户输入的值
    private List<String> keywords;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String execute() throws Exception{
        String[] arr = {"a1", "a2", "a3", "a4", "b1", "b2", "b3"};
        if(!"".equals(input) && input != null){
            keywords = new ArrayList<>();
            for(String word: arr){
                if(word.contains(input)){
                    keywords.add(word);
                }
            }
        }
        return SUCCESS;
    }
}

