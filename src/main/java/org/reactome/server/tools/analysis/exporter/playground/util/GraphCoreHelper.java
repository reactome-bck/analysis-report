package org.reactome.server.tools.analysis.exporter.playground.util;

import org.reactome.server.analysis.core.result.PathwayNodeSummary;
import org.reactome.server.graph.domain.model.Pathway;
import org.reactome.server.graph.service.DatabaseObjectService;
import org.reactome.server.graph.service.GeneralService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuan-Deng dengchuanbio@gmail.com
 */
public class GraphCoreHelper {

    private static GeneralService genericService;
    private static DatabaseObjectService databaseObjectService;

    static {
        ApplicationContext context = new AnnotationConfigApplicationContext(GraphCoreConfig.class);
        genericService = context.getBean(GeneralService.class);
        databaseObjectService = context.getBean(DatabaseObjectService.class);
    }

    /**
     * get pathways detail information from neo4j database by given the target pathway identifiers array.
     *
     * @param pathways {@see org.reactome.server.tools.analysis.exporter.playground.model.Pathway}
     * @return {@code Pathway[]} array contains the pathway detail information.
     */
    public static Pathway[] getPathway(List<PathwayNodeSummary> pathways) {
        List<Object> StIds = new ArrayList<>();
        pathways.forEach(pathway -> StIds.add(pathway.getStId()));
        return databaseObjectService.findByIdsNoRelations(StIds).toArray(new Pathway[StIds.size()]);
    }

    /**
     * @return Reactome's current database version.
     */
    public static int getDBVersion() {
        return genericService.getDBVersion();
    }
}