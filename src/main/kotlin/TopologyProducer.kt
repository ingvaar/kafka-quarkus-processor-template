import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.Topology
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces

@ApplicationScoped
class TopologyProducer {
    @field:ConfigProperty(name = "topic.in", defaultValue = "topic.in")
    lateinit var topicIn: String
    @field:ConfigProperty(name = "topic.out", defaultValue = "topic.out")
    lateinit var topicOut: String

    private val logger: Logger = LoggerFactory.getLogger(TopologyProducer::class.java)

    @Produces
    fun buildTopology(): Topology {

        logger.info("Hello world!")

        return StreamsBuilder().apply {
            // Add topology here
        }.build()
    }
}
