package com.my.blog.website.utils;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.util.Arrays;


/**
 * 将 markdown 文档 转为 HTML
 * <p>
 * Created by yihui on 2017/9/9.
 */
public class MarkDown2HtmlWrapper {

    public static String MD_CSS = null;

    static {
        MD_CSS = buildCssContent("md/huimarkdown.css");
    }

    public static String buildCssContent(String file) {
        String css;
        try {
            css = FileReadUtil.readAll(file);
            css = "<style type=\"text/css\">\n" + css + "\n</style>\n";
            System.out.println("css:"+css);
        } catch (Exception e) {
            css = "";
        }
        return css;
    }

    /**
     * 直接将markdown语义的文本转为html格式输出
     *
     * @param content markdown语义文本
     * @return
     */
    public static MarkdownEntity ofContent(String content) {
        String html = parse(content);
        MarkdownEntity entity = new MarkdownEntity(html);
        entity.setCss(MD_CSS);
//        entity.MarkdownEntity(html);
        entity.addDivStyle("class", "markdown-body ");
        return entity;
    }


    /**
     * markdown to html
     *
     * @param content markdown contents
     * @return parse html contents
     */
    public static String parse(String content) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);

        // enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));


        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(content);
        return renderer.render(document);
    }

}