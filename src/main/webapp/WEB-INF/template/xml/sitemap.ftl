<?xml version="1.0" encoding="utf-8"?>

<urlset>
<#list siteMaps as sm>
    <url>
        <loc>${sm.loc}</loc>
        <lastmod>${sm.lastmod}</lastmod>
        <changefreq>${sm.changefreq}</changefreq>
        <priority>${sm.priority}</priority>
    </url>
</#list>
</urlset>